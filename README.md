# pet-plus

Setar nas configurações do Spring Boot as seguintes configurações:

Para envio de e-mail (atualmente configurado no Spring Boot para usar o smtp do Gmail)

spring.mail.username -> Login do e-mail

spring.mail.password -> Senha


Para redirecionamento de mensagem enviada por e-mail

hostAndPort -> No e-mail enviado, será enviado um link de acesso e a montagem correta do link depende da configuração do Host e Porta tutilizada pela aplicação


Exemplo passando configurações via parametros (mais detalhes emhttp://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html):

java -jar petplus-1.0.0.war --spring.config.location=classpath:application.properties --spring.mail.username=ENVIAR@gmail.com --spring.mail.password=ABC --hostAndPort=http://DOMINIO:8080
