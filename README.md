# Dataservice
Dit project is een service die verantwoordelijk is voor het converteren van een RabbitMQ message naar een Websocket message.

## Feature_FMBM-105
Deze feature is voor de websocket. Deze word getest met de Backend_integration_testing repository.
**Deze branch is op het gegeven moment niet werkend**
Dit komt doordat er een mismatch is tussen de message die de websocket wil versturen en de ontvanger wil ontvangen.
Gebruik Backend_integration_testing om dit te testen.

## Setup
1. Clone de Gitrepository
2. Check de docker-compose of deze correct is geconfigureerd

## Startup
1. Open een command prompt
2. Navigeer naar de root directory van dit project
3. Gebruik het volgende commando om Dataservice en RabbitMQ met docker te starten:
````
docker-compose up --build
````
Done!
