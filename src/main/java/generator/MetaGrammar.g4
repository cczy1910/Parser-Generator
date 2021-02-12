grammar MetaGrammar;

@header {
package generator.gen;
import generator.ast.*;
import java.util.*;
import java.util.stream.Collectors;
}

gram returns[Grammar gr]
    : name=gramName head=header ntd=notermDeclBlock tkd=tokenDeclBlock {$gr = new Grammar($name.name, $head.head, $ntd.ruleList, $tkd.ruleList);}
    ;

gramName returns[String name]: 'grammar' id=TokenIdentifier ';' {$name = $id.text;};

header returns[String head]: 'header' ci=CodeInject {$head = $ci.text;};

notermDeclBlock returns[List<Rule> ruleList]
    :
        {
            $ruleList = new ArrayList<>();
        }
        (rl=notermDecl {$ruleList.add($rl.rl);})+;

tokenDeclBlock returns[List<MetaToken> ruleList]
    :
        {
            $ruleList = new ArrayList<>();
        }
        (tk=tokenDecl {$ruleList.add($tk.tk);})+;

notermDecl returns[Rule rl]
    :
        {
            String ruleName = null;
            String ruleArg = null;
            String ruleVal = null;
            List<RuleWay> ruleWays = new ArrayList<>();
        }
        name=NotermIdentifier {ruleName = $name.text;}
        (arg=CodeInject {ruleArg = $arg.text.substring(1, $arg.text.length() - 1);})?
        ('returns' val=CodeInject {ruleVal = $val.text.substring(1, $val.text.length() - 1);})?
        ':'
        way=ruleWay {ruleWays.add($way.way);}
        ('|' way=ruleWay {ruleWays.add($way.way);})*
        ';'
        {
            $rl = new Rule(ruleName, ruleArg, ruleVal, ruleWays);
        }
    ;

tokenDecl returns[MetaToken tk]
    :
        {
            String tokenName = null;
            String tokenRegexp = null;
            boolean skip = false;
        }
        name=TokenIdentifier ':'
        re=Regexp
        ('->' 'skip' {skip = true;})?
        ';'
        {
            $tk = new MetaToken($name.text, $re.text.substring(1, $re.text.length() - 1), skip);
        };

ruleWay returns [RuleWay way]
    :
        {
            List<Invokation> invList = new ArrayList<>();
            String code = null;
        }
        (re=ruleEntry {invList.add($re.inv);})*
        (ci=CodeInject {code = $ci.text.substring(1, $ci.text.length() - 1);})?
        {
            $way = new RuleWay(invList, code);
        }
        ;


ruleEntry returns[Invokation inv]
    : nt=noterm {$inv = $nt.inv;}
    | tk=token {$inv = $tk.inv;}
    ;

noterm returns[RuleInvokation inv]
    :
        {
            String ruleName = null;
            String ruleAlias = null;
            String ruleArg = null;
        }
        (alias=Alias {ruleAlias = $alias.text.substring(1, $alias.text.length() - 1);})?
        name=NotermIdentifier  {ruleName = $name.text;}
        ('(' arg=CodeInject ')' {ruleArg = $arg.text.substring(1, $arg.text.length() - 1);})?
        {
            $inv = new RuleInvokation(ruleName, ruleAlias, ruleArg);
        }
    ;


token returns[TokenInvokation inv]
    :
        {
            String tokenName = null;
            String tokenAlias = null;
        }
        (alias=Alias {tokenAlias = $alias.text.substring(1, $alias.text.length() - 1);})?
        name=TokenIdentifier {tokenName = $name.text;}
        {
            $inv = new TokenInvokation(tokenName, tokenAlias);
        }
    ;


NotermIdentifier : LowLetter LetterOrDigit*;

TokenIdentifier : UppLetter LetterOrDigit*;

Alias : '$' Letter LetterOrDigit* '=';

IntegerLiteral : ('0' | NonZeroDigit Digit*);

FloatLiteral : IntegerLiteral '.' Digit Digit*;

CodeInject: '#' (~[#])*? '#';

Regexp: '"' (~["])*? '"';

fragment
NonZeroDigit : [1-9];

fragment
Digit : [0-9];

fragment
Letter : [a-zA-Z_];

fragment
UppLetter : [A-Z];

fragment
LowLetter : [a-z];

fragment
LetterOrDigit : [a-zA-Z0-9_];

WS : [ \t\r\n]+ -> skip;


