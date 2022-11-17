FROM python:3.10-slim

RUN apt update && \
    apt install openjdk-8-jdk && \
    pip install launchable

ENTRYPOINT [ "launchable", "verify" ]
