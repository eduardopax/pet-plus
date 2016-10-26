FROM	eduardopax/debian8-oracle8jdk-maven-git

MAINTAINER Eduardo Lealdini Ramalho <eduardopax@gmail.com>

RUN		mkdir /app

WORKDIR	/app

RUN		git clone https://github.com/eduardopax/pet-plus.git

WORKDIR	/app/pet-plus

RUN 	mvn install -Dmaven.test.skip=true

RUN		cp target/$(ls target | grep petplus | grep .war | grep -v original) /app

WORKDIR	/app

# Clean
RUN		apt-get clean all && \
		rm -rf /app/pet-plus &&\
		rm -rf /root/.m2

ENV USERNAME USERNAME

ENV PASSWORD PASSWORD

ENV HOST LOCALHOST

ENV PORT 8080

EXPOSE $PORT
		
ENTRYPOINT ["sh", "-c", "java -jar $(ls | grep petplus) --spring.mail.username=$USERNAME --spring.mail.password=$PASSWORD --hostAndPort=http://$HOST:$PORT --server.port=$PORT"]