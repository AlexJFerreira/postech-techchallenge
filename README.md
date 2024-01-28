# postech-techchallenge

Para executar a aplicação localmente:
- Na raiz do projeto, executar o comando: kubectl apply -f manifests
- Aguardar alguns segundos até que todos os pods estejam em estado Running. 
- O banco de dados estará disponivel para conexão local na localhost:30036 e a api na localhost:31000.

Para acessar o swagger após a api estar executando:
- http://localhost:31000/swagger-ui/index.html

Video demonstração arquitetura
- https://www.youtube.com/watch?v=3zaAA5JuGYY

Collection Postman
- No diretório collection do projeto

Arquivos Kubernetes
- No diretório manifests do projeto

Diagramas
- https://drive.google.com/drive/u/0/folders/1FaDNRh5tZtmGI92RW1n4vaoXguV26uoU