
package com.example.calculator;
import java_cup.runtime.Symbol;
%%

%class Lexer
%public
%line
%char
%cup
%unicode
%ignorecase
%init{
	yyline = 1;
	yychar = 1;
%init}


DELIM=[ \r\t]+
NUMBER=[0-9]+("."[  |0-9]+)?

%%
"+" {return new Symbol(sym.SUM,yyline,(int)yychar, yytext());}
"-" {return new Symbol(sym.MIN,yyline,(int)yychar, yytext());}
"*" {return new Symbol(sym.MUL,yyline,(int)yychar, yytext());}
"/" {return new Symbol(sym.DIV,yyline,(int)yychar, yytext());}

{DELIM} {}
{NUMBER} {return new Symbol(sym.NUMBER,yyline,(int)yychar, yytext());}


. {
	System.out.println("Lexer error: "+yytext()+
	", line: "+yyline+", column: "+yychar);
}


