Para correr la aplicación:
	Run As > Maven build
	En goals escribir: spring-boot:run
	
	
Si tira error cuando quiere instanciar el tomcatEmbebedBean, es necesario correr este comando dentro del 
proyecto desde lineas de comando:
	mvn dependency:purge-local-repository