# Parser-Generator

### Language recognition tool.

Takes as input a grammar that specifies a language and generates 
as output source code for a recognizer. 

#### Input Grammar Format

The input file must contain a LL(1) context-free grammar. 

The first line of the file must contain grammar name in format: ```grammar GrammarName;```

Following lines must describe a grammar in extended Backus–Naur form. Starting rule must be declared first. 
Token names start with uppercase. Tokens are defined by a regular expression.
Non-terminal rule names start with lowercase.   Empty (epsilon) rules are also supported. 

For example, the grammar of correct bracket sequences might be specified like this:

```
grammar CBS;

cbs : LB cbs RB cbsTail | ;
cbsTail : cbs cbsTail | ;

LB : "(";
RB : ")";
```

#### Parsing with generated recognizers 

Generated recognizer parses the text and returns a 
syntax tree, which consists of context nodes for 
rules in grammar. 

Each node in a tree is an object with superclass ``Context``. Nodes that represent a non-terminal rule contain a list of children. They have a class ``*RuleName*Context``. 
Token nodes contain the token type and text and have a class ``TokenContext``.

#### Attributes

Both synthesized and inherited attributes are supported via insertions 
of Java code in format: ``# code #``.  

To declare the inherited attribute for a rule you need to place a code insertion right after the rule name. To declare synthesized attributes keyword ``returns`` and code insertion is used.

Synthesized attributes are put into fields in context and might
be accessed both in the parsing process and in a resulting tree. 
To compute synthesized attribute you need to add a code insertion at the end of rule way.
Parsing functions are constructors so attributes of a current node can be accessed using Java keyword ``this``. 
To get the synthesized attributes of child node you need to declare an alias for its rule in format ``$alias=rule``, then you can access it as a variable.

For example, the grammar which calculates the sum of the list as an attribute:

```
grammar ListSum;

list returns #int sum# 
    : $elem=NUMBER $tail=listTail #
            this.sum = Integer.parseInt(elem.text) + tail.sum;
        #
    ;


listTail returns #int sum# 
    : COMMA $elem=NUMBER $tail=listTail #
            this.sum = Integer.parseInt(elem.text) + tail.sum;
        #
    | #
            this.sum = 0;
        #
    ;

COMMA : ",";
NUMBER : "0|([1-9][0-9]*)";
```

Inherited attributes must be passed to a sub-rules using code insertion in brackets.
They can also be used to compute synthesized attributes.

Example of combined usage of synthesized and inherited attributes in arithmetic expression grammar can be found in the file ``src/main/java/calc/CalcGrammar.gr``.

 
