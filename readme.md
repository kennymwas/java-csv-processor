This is a simple java-cs-processor written in core java
1. There is a CsvColumn interface used for default converters for all fields.
2. Any TestModel data should be annotated for it to be processed @CsvColumn and a name given for it to be processed.
3. We are assuming the field annotated its our header.
4.In the main method the user is given a leeway to pass the path filename,column seperator and TestModel he/she wants.
5.All the business logic is in CsvProcessor.
