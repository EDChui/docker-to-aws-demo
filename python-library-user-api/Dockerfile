# Ref: https://docs.aws.amazon.com/lambda/latest/dg/images-create.html
FROM public.ecr.aws/lambda/python:3.9

WORKDIR ${LAMBDA_TASK_ROOT}

COPY /requirements.txt ./requirements.txt

RUN pip install --no-cache-dir --upgrade -r ./requirements.txt

COPY /app ./

CMD ["main.handler"]
