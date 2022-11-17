FROM python:3.10-slim

RUN apt -y update && \
    apt -y install default-jre && \
    pip install launchable

ENTRYPOINT [ "launchable", "verify" ]
