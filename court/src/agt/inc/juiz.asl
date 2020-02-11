// Agent juiz in project court

/* Initial beliefs and rules */

/* Initial goals */

!finalizado.
!create_and_use.



+!create_and_use : true<- !setupTool(Id).

+!setupTool(Id): true<- makeArtifact("c0","court.raciocinio",[],Id).


/* Plans */

+!julgar	 : true <- judge ; .print("Julgado").


+!finalizado
	: true
	<- .at("now + 5 seconds", {+!julgar})
		.at("now + 3 seconds", {+!recebeArgumento}).

+!recebeArgumento
	:	.findall(arg(I,N,A), arg(I, N, A), L) &
		.length(L, 5)
	<- for(arg(I,N,A)){
		.print(I,N,A)
		makeSimpleArgument(I,N,A)
		}
	.
	
	/* 
+signal("RenatoCulpado") : true <- .print("Renato Culpado").
+CristianoCulpado : true <- .print("Cristiano Culpado").
+signal("SemProvasSuficientes") : true <- .print("Sem Provas Suficientes").
*/
+print(A) 
  <- .print(A).

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }
{ include("$moiseJar/asl/org-obedient.asl") }
//addArgument(new Argument(1, "Renato Culpado", NULL))