package calc.gen;

import java.util.ArrayList;
import java.util.List;

public class CalcGrammarParser {
    CalcGrammarLexer lexer;

    public CalcGrammarParser(String input) {
        this.lexer = new CalcGrammarLexer(input);
    }

    public enum TokenType {
       ADD, SQ, ABS, SUBT, MUL, DIV, SHL, SHR, LB, RB, NUM, WS, EOF;
    }

    public static abstract class Context {
        public List<Context> children = new ArrayList<>();

    }

    public static class TokenContext extends Context{
        public TokenType type;
        public String text;
        
        public TokenContext(TokenType type, String text) {
            this.type = type;
            this.text = text;
        }

    }

    public ShContext parse() {
        return new ShContext(this.lexer);
    }

    public static class ShContext extends Context {
        public int res;
        public ShContext(CalcGrammarLexer lexer) {
            switch(lexer.curToken.type) {
                case ABS:
                case SUBT:
                case NUM:
                case LB:
                case SQ:
                {
                    children.add(new AsContext(lexer));
                    AsContext asRes = (AsContext) children.get(children.size() - 1);
                    children.add(new ShtContext(asRes.res, lexer));
                    ShtContext shtRes = (ShtContext) children.get(children.size() - 1);
                    this.res = shtRes.res;
                    }
                    break;
                default:
                    throw new RuntimeException("Unexpected Token");
            }
        }
    }

    public static class ShtContext extends Context {
        public int res;
        public ShtContext(int acc, CalcGrammarLexer lexer) {
            switch(lexer.curToken.type) {
                case SHL:
                {
                    if (lexer.curToken.type == TokenType.SHL) {
                        children.add(lexer.curToken);
                        lexer.nextToken();
                    } else {
                        throw new RuntimeException("Unexpected Token" + lexer.curToken.type.toString());
                    }
                    children.add(new AsContext(lexer));
                    AsContext asRes = (AsContext) children.get(children.size() - 1);
                    children.add(new ShtContext(acc << asRes.res, lexer));
                    ShtContext shtRes = (ShtContext) children.get(children.size() - 1);
                    this.res = shtRes.res;
                    }
                    break;
                case SHR:
                {
                    if (lexer.curToken.type == TokenType.SHR) {
                        children.add(lexer.curToken);
                        lexer.nextToken();
                    } else {
                        throw new RuntimeException("Unexpected Token" + lexer.curToken.type.toString());
                    }
                    children.add(new AsContext(lexer));
                    AsContext asRes = (AsContext) children.get(children.size() - 1);
                    children.add(new ShtContext(acc >> asRes.res, lexer));
                    ShtContext shtRes = (ShtContext) children.get(children.size() - 1);
                    this.res = shtRes.res;
                    }
                    break;
                case EOF:
                case RB:
                {
                    this.res = acc;
                }
                    break;
                default:
                    throw new RuntimeException("Unexpected Token");
            }
        }
    }

    public static class AsContext extends Context {
        public int res;
        public AsContext(CalcGrammarLexer lexer) {
            switch(lexer.curToken.type) {
                case ABS:
                case SUBT:
                case NUM:
                case LB:
                case SQ:
                {
                    children.add(new MdContext(lexer));
                    MdContext mdRes = (MdContext) children.get(children.size() - 1);
                    children.add(new AstContext(mdRes.res, lexer));
                    AstContext astRes = (AstContext) children.get(children.size() - 1);
                    this.res = astRes.res;
                    }
                    break;
                default:
                    throw new RuntimeException("Unexpected Token");
            }
        }
    }

    public static class AstContext extends Context {
        public int res;
        public AstContext(int acc, CalcGrammarLexer lexer) {
            switch(lexer.curToken.type) {
                case ADD:
                {
                    if (lexer.curToken.type == TokenType.ADD) {
                        children.add(lexer.curToken);
                        lexer.nextToken();
                    } else {
                        throw new RuntimeException("Unexpected Token" + lexer.curToken.type.toString());
                    }
                    children.add(new MdContext(lexer));
                    MdContext mdRes = (MdContext) children.get(children.size() - 1);
                    children.add(new AstContext(acc + mdRes.res, lexer));
                    AstContext astRes = (AstContext) children.get(children.size() - 1);
                    this.res = astRes.res;
                    }
                    break;
                case SUBT:
                {
                    if (lexer.curToken.type == TokenType.SUBT) {
                        children.add(lexer.curToken);
                        lexer.nextToken();
                    } else {
                        throw new RuntimeException("Unexpected Token" + lexer.curToken.type.toString());
                    }
                    children.add(new MdContext(lexer));
                    MdContext mdRes = (MdContext) children.get(children.size() - 1);
                    children.add(new AstContext(acc - mdRes.res, lexer));
                    AstContext astRes = (AstContext) children.get(children.size() - 1);
                    this.res = astRes.res;
                    }
                    break;
                case SHL:
                case EOF:
                case SHR:
                case RB:
                {
                    this.res = acc;
                }
                    break;
                default:
                    throw new RuntimeException("Unexpected Token");
            }
        }
    }

    public static class MdContext extends Context {
        public int res;
        public MdContext(CalcGrammarLexer lexer) {
            switch(lexer.curToken.type) {
                case ABS:
                case SUBT:
                case NUM:
                case LB:
                case SQ:
                {
                    children.add(new UnContext(lexer));
                    UnContext unRes = (UnContext) children.get(children.size() - 1);
                    children.add(new MdtContext(unRes.res, lexer));
                    MdtContext mdtRes = (MdtContext) children.get(children.size() - 1);
                    this.res = mdtRes.res;
                    }
                    break;
                default:
                    throw new RuntimeException("Unexpected Token");
            }
        }
    }

    public static class MdtContext extends Context {
        public int res;
        public MdtContext(int acc, CalcGrammarLexer lexer) {
            switch(lexer.curToken.type) {
                case MUL:
                {
                    if (lexer.curToken.type == TokenType.MUL) {
                        children.add(lexer.curToken);
                        lexer.nextToken();
                    } else {
                        throw new RuntimeException("Unexpected Token" + lexer.curToken.type.toString());
                    }
                    children.add(new UnContext(lexer));
                    UnContext unRes = (UnContext) children.get(children.size() - 1);
                    children.add(new MdtContext(acc * unRes.res, lexer));
                    MdtContext mdtRes = (MdtContext) children.get(children.size() - 1);
                    this.res = mdtRes.res;
                    }
                    break;
                case DIV:
                {
                    if (lexer.curToken.type == TokenType.DIV) {
                        children.add(lexer.curToken);
                        lexer.nextToken();
                    } else {
                        throw new RuntimeException("Unexpected Token" + lexer.curToken.type.toString());
                    }
                    children.add(new UnContext(lexer));
                    UnContext unRes = (UnContext) children.get(children.size() - 1);
                    children.add(new MdtContext(acc / unRes.res, lexer));
                    MdtContext mdtRes = (MdtContext) children.get(children.size() - 1);
                    this.res = mdtRes.res;
                    }
                    break;
                case ADD:
                case SUBT:
                case SHL:
                case EOF:
                case SHR:
                case RB:
                {
                    this.res = acc;
                }
                    break;
                default:
                    throw new RuntimeException("Unexpected Token");
            }
        }
    }

    public static class UnContext extends Context {
        public int res;
        public UnContext(CalcGrammarLexer lexer) {
            switch(lexer.curToken.type) {
                case SUBT:
                {
                    if (lexer.curToken.type == TokenType.SUBT) {
                        children.add(lexer.curToken);
                        lexer.nextToken();
                    } else {
                        throw new RuntimeException("Unexpected Token" + lexer.curToken.type.toString());
                    }
                    children.add(new UnContext(lexer));
                    UnContext unRes = (UnContext) children.get(children.size() - 1);
                    this.res = -unRes.res;
                    }
                    break;
                case LB:
                {
                    if (lexer.curToken.type == TokenType.LB) {
                        children.add(lexer.curToken);
                        lexer.nextToken();
                    } else {
                        throw new RuntimeException("Unexpected Token" + lexer.curToken.type.toString());
                    }
                    children.add(new ShContext(lexer));
                    ShContext shRes = (ShContext) children.get(children.size() - 1);
                    if (lexer.curToken.type == TokenType.RB) {
                        children.add(lexer.curToken);
                        lexer.nextToken();
                    } else {
                        throw new RuntimeException("Unexpected Token" + lexer.curToken.type.toString());
                    }
                    this.res = shRes.res;
                    }
                    break;
                case NUM:
                {
                    if (lexer.curToken.type == TokenType.NUM) {
                        children.add(lexer.curToken);
                        lexer.nextToken();
                    } else {
                        throw new RuntimeException("Unexpected Token" + lexer.curToken.type.toString());
                    }
                    TokenContext numRes = (TokenContext) children.get(children.size() - 1);
                    this.res = Integer.parseInt(numRes.text);
                    }
                    break;
                case SQ:
                {
                    if (lexer.curToken.type == TokenType.SQ) {
                        children.add(lexer.curToken);
                        lexer.nextToken();
                    } else {
                        throw new RuntimeException("Unexpected Token" + lexer.curToken.type.toString());
                    }
                    if (lexer.curToken.type == TokenType.LB) {
                        children.add(lexer.curToken);
                        lexer.nextToken();
                    } else {
                        throw new RuntimeException("Unexpected Token" + lexer.curToken.type.toString());
                    }
                    children.add(new ShContext(lexer));
                    ShContext shRes = (ShContext) children.get(children.size() - 1);
                    if (lexer.curToken.type == TokenType.RB) {
                        children.add(lexer.curToken);
                        lexer.nextToken();
                    } else {
                        throw new RuntimeException("Unexpected Token" + lexer.curToken.type.toString());
                    }
                    this.res = shRes.res * shRes.res;
                    }
                    break;
                case ABS:
                {
                    if (lexer.curToken.type == TokenType.ABS) {
                        children.add(lexer.curToken);
                        lexer.nextToken();
                    } else {
                        throw new RuntimeException("Unexpected Token" + lexer.curToken.type.toString());
                    }
                    if (lexer.curToken.type == TokenType.LB) {
                        children.add(lexer.curToken);
                        lexer.nextToken();
                    } else {
                        throw new RuntimeException("Unexpected Token" + lexer.curToken.type.toString());
                    }
                    children.add(new ShContext(lexer));
                    ShContext shRes = (ShContext) children.get(children.size() - 1);
                    if (lexer.curToken.type == TokenType.RB) {
                        children.add(lexer.curToken);
                        lexer.nextToken();
                    } else {
                        throw new RuntimeException("Unexpected Token" + lexer.curToken.type.toString());
                    }
                    this.res = Math.abs(shRes.res);
                    }
                    break;
                default:
                    throw new RuntimeException("Unexpected Token");
            }
        }
    }

    public static class CalcGrammarLexer {
        String input;
        int index = 0;
        TokenContext curToken;
        
    
        public CalcGrammarLexer(String input) {
            this.input = input;
            this.nextToken();
        }
    
        public TokenContext nextToken() {
            if (this.index == this.input.length()) {
                curToken = new TokenContext(TokenType.EOF, "");
                return curToken;
            }
            TokenContext newToken = null;
            int newIndex = -1;
            for (int i = index + 1; i <= this.input.length(); i++) {
                String curSubstring = input.substring(index, i);
                if(curSubstring.matches("\\+")) {
                    newToken = new TokenContext(TokenType.ADD, curSubstring);
                    newIndex = i;
                }
            }
            if (newToken != null) {
                index = newIndex;
                curToken = newToken;
                return curToken;
            }
            for (int i = index + 1; i <= this.input.length(); i++) {
                String curSubstring = input.substring(index, i);
                if(curSubstring.matches("square")) {
                    newToken = new TokenContext(TokenType.SQ, curSubstring);
                    newIndex = i;
                }
            }
            if (newToken != null) {
                index = newIndex;
                curToken = newToken;
                return curToken;
            }
            for (int i = index + 1; i <= this.input.length(); i++) {
                String curSubstring = input.substring(index, i);
                if(curSubstring.matches("abs")) {
                    newToken = new TokenContext(TokenType.ABS, curSubstring);
                    newIndex = i;
                }
            }
            if (newToken != null) {
                index = newIndex;
                curToken = newToken;
                return curToken;
            }
            for (int i = index + 1; i <= this.input.length(); i++) {
                String curSubstring = input.substring(index, i);
                if(curSubstring.matches("-")) {
                    newToken = new TokenContext(TokenType.SUBT, curSubstring);
                    newIndex = i;
                }
            }
            if (newToken != null) {
                index = newIndex;
                curToken = newToken;
                return curToken;
            }
            for (int i = index + 1; i <= this.input.length(); i++) {
                String curSubstring = input.substring(index, i);
                if(curSubstring.matches("\\*")) {
                    newToken = new TokenContext(TokenType.MUL, curSubstring);
                    newIndex = i;
                }
            }
            if (newToken != null) {
                index = newIndex;
                curToken = newToken;
                return curToken;
            }
            for (int i = index + 1; i <= this.input.length(); i++) {
                String curSubstring = input.substring(index, i);
                if(curSubstring.matches("/")) {
                    newToken = new TokenContext(TokenType.DIV, curSubstring);
                    newIndex = i;
                }
            }
            if (newToken != null) {
                index = newIndex;
                curToken = newToken;
                return curToken;
            }
            for (int i = index + 1; i <= this.input.length(); i++) {
                String curSubstring = input.substring(index, i);
                if(curSubstring.matches("<<")) {
                    newToken = new TokenContext(TokenType.SHL, curSubstring);
                    newIndex = i;
                }
            }
            if (newToken != null) {
                index = newIndex;
                curToken = newToken;
                return curToken;
            }
            for (int i = index + 1; i <= this.input.length(); i++) {
                String curSubstring = input.substring(index, i);
                if(curSubstring.matches(">>")) {
                    newToken = new TokenContext(TokenType.SHR, curSubstring);
                    newIndex = i;
                }
            }
            if (newToken != null) {
                index = newIndex;
                curToken = newToken;
                return curToken;
            }
            for (int i = index + 1; i <= this.input.length(); i++) {
                String curSubstring = input.substring(index, i);
                if(curSubstring.matches("\\(")) {
                    newToken = new TokenContext(TokenType.LB, curSubstring);
                    newIndex = i;
                }
            }
            if (newToken != null) {
                index = newIndex;
                curToken = newToken;
                return curToken;
            }
            for (int i = index + 1; i <= this.input.length(); i++) {
                String curSubstring = input.substring(index, i);
                if(curSubstring.matches("\\)")) {
                    newToken = new TokenContext(TokenType.RB, curSubstring);
                    newIndex = i;
                }
            }
            if (newToken != null) {
                index = newIndex;
                curToken = newToken;
                return curToken;
            }
            for (int i = index + 1; i <= this.input.length(); i++) {
                String curSubstring = input.substring(index, i);
                if(curSubstring.matches("0|([1-9][0-9]*)")) {
                    newToken = new TokenContext(TokenType.NUM, curSubstring);
                    newIndex = i;
                }
            }
            if (newToken != null) {
                index = newIndex;
                curToken = newToken;
                return curToken;
            }
            for (int i = index + 1; i <= this.input.length(); i++) {
                String curSubstring = input.substring(index, i);
                if(curSubstring.matches("[ \r\n\t]")) {
                    newIndex = i;
                }
            }
            if (newIndex != -1) {
                index = newIndex;
                return nextToken();
            }
            throw new RuntimeException("Input Mismatch");
        }
    }
}
