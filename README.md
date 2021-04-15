# IPL Dashboard APP

## IPL Dashboard built using Spring Boot, Spring, HSQL DB and React.

### Backend
- HSQL DB- 
  - It is a relational database management system written in Java.
  - The main and unique feature of HSQLDB is Standard Compliance. It can provide database access within the user's application process, within an application server, or as a        separate server process
  - HSQLDB uses in-memory structure for fast operations against DB server. It uses disk persistence as per user flexibility, with a reliable crash recovery.
- Spring Batch Process- 
  -  A batch process is typically encapsulated by a Job consisting of multiple Steps. Each Step typically has a single ItemReader, ItemProcessor, and ItemWriter. A Job is executed by a JobLauncher, and metadata about configured and executed jobs is stored in a JobRepository.
  - A job can have more than one steps – and every step typically follows the sequence of reading data, processing it and writing it.
  - Our Batch Job ingests the data from an external source(csv file here) and stores in an internal HSQL DB in the Spring Boot app.
- Spring Boot APIs

### Frontend
- React- On the frontend React is used to talk to the Spring Boot Api and display the data.
- HTML,CSS

>Data Source - https://www.kaggle.com/patrickb1912/ipl-complete-dataset-20082020
