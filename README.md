# pet-plus

**_Setar no Spring Boot as seguintes configurações:_**

Para envio de e-mail (atualmente configurado no Spring Boot para usar o smtp do Gmail)

**spring.mail.username** -> Login do e-mail

**spring.mail.password** -> Senha


Para redirecionamento de mensagem enviada por e-mail

**hostAndPort** -> No e-mail enviado, será enviado um link de acesso e a montagem correta do link depende da configuração do Host e Porta tutilizada pela aplicação


Exemplo passando configurações via parametros (mais detalhes em http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html):

_java -jar petplus-1.0.0.war --spring.mail.username=ENVIAR@gmail.com --spring.mail.password=ABC --hostAndPort=http://DOMINIO:8080_



**_Acesso ao sistema_**

/DOMINIO -> página principa

/DOMINIO/list -> lista os registros cadastrados (Login/Senha -> admin/admin)


**_Docker_**

Criando um container Docker pelo arquivo Dockerfile, execute passando os parametros correspondentes acima da segunte forma:

_docker run -e USERNAME=usuarioemail -e PASSWORD=password -e HOST=localhost -e PORT=porta NOMEIMAGEM_

Obs: A aplicação subirá na porta setada em PORT.