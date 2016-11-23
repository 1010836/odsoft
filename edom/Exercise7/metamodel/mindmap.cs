SYNTAXDEF mindmap
FOR <http://org/eclipse/dsl/mindmap>
START Map


TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
	DEFINE INTEGER $('-')?('1'..'9')('0'..'9')*|'0'$;
	DEFINE FLOAT $('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
}


TOKENSTYLES {
	"Map" COLOR #7F0055, BOLD;
	"title" COLOR #7F0055, BOLD;
	"created" COLOR #7F0055, BOLD;
	"elements" COLOR #7F0055, BOLD;
	"rootTopics" COLOR #7F0055, BOLD;
	"Topic" COLOR #7F0055, BOLD;
	"name" COLOR #7F0055, BOLD;
	"description" COLOR #7F0055, BOLD;
	"start" COLOR #7F0055, BOLD;
	"end" COLOR #7F0055, BOLD;
	"priority" COLOR #7F0055, BOLD;
	"subtopics" COLOR #7F0055, BOLD;
	"parent" COLOR #7F0055, BOLD;
	"Relationship" COLOR #7F0055, BOLD;
	"Type" COLOR #7F0055, BOLD;
}


RULES {
	Map ::= "Map" "{" ("title" ":" title['"','"'] | "created" ":" created[] | "elements" ":" elements)* "}";
	Topic ::= "Topic" "{" ("name" ":" name['"','"'] | "description" ":" description['"','"'] | "start" ":" start[] | "end" ":" end[] | "priority" ":" priority[HIGH:"HIGH", MEDIUM:"MEDIUM", LOW:"LOW"] | "parent" ":" parent[])* "}";
	Relationship ::= "Relationship" "{" ("name" ":" name['"','"'] | "Type" ":" Type[DEPENDENCY:"DEPENDENCY", INCLUDE:"INCLUDE", EXTEND:"EXTEND"])* "}";
}