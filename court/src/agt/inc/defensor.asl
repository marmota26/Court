// Agent defensor in project court

/* Initial beliefs and rules */


/* Initial goals */

!argumentar.

/* Plans */


+!argumentar 
	: true 
	<- .send(juiz, tell, arg(4, "Pistola do Cristiano", 1)) 
	   .send(juiz, tell, arg(5, "Pistola na Autopsia", 3))
	   .send(juiz, tell, arg(2, "CristianoCulpado", 0))
		.print("Argumentado").
	   

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
