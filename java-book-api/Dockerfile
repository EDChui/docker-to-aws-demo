# Using this Dockerfile, Gradle clean build has to be executed first before build and running this application in Docker.
# Gradle clean build can be done in IDE such as IntelliJ.
# Use this to reduce the time needed to build the .jar files each time when deploy locally.

# Ref: https://gallery.ecr.aws/lambda/java
FROM public.ecr.aws/lambda/java:11

# Copy function code and runtime dependencies from Gradle layout
COPY build/classes/java/main ${LAMBDA_TASK_ROOT}
COPY build/dependency/* ${LAMBDA_TASK_ROOT}/lib/

# Set the CMD to your handler (could also be done as a parameter override outside of the Dockerfile)
CMD ["com.example.book.StreamLambdaHandler::handleRequest"]