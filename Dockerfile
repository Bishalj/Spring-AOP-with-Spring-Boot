# Start with a base image containing Java runtime
FROM gradle:4.4.0-alpine

# Add Maintainer Info
MAINTAINER bishal.j@turtlemint.com

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8009 available to the world outside this container
EXPOSE 8080

WORKDIR .
RUN gradle build

#Add the application jar into the container
ADD ./build/libs/SpringAspect-0.0.1-SNAPSHOT.jar SpringAspect

ENTRYPOINT ["java","-jar","SpringAspect"]
