FROM hseeberger/scala-sbt:8u222_1.3.5_2.13.1

ENV UI_TYPE=tui

ADD . /UNO
WORKDIR /UNO
RUN sbt compile

CMD sbt run