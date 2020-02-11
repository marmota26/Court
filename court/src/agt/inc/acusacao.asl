// Agent acusacao in project court

/* Initial beliefs and rules */

/* Initial goals */

!argumentar.

/* Plans */


+!argumentar 
	: true 
	<- .send(juiz, tell, arg(3, "FacaDoRenato", 2))
	   .send(juiz, tell, arg(1, "RenatoCulpado", 0))
		.print("Argumentado").
	   
{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
