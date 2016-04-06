CREATE TABLE PROJECT (id BIGINT NOT NULL AUTO_INCREMENT, name VARCHAR(30), PRIMARY KEY (id));

CREATE TABLE CONTRACT (id BIGINT NOT NULL AUTO_INCREMENT, code VARCHAR(30), description VARCHAR(300),  vendor VARCHAR(30), budget DECIMAL(7,2), committed_cost DECIMAL(7,2), forecast DECIMAL(7,2), paid DECIMAL(7,2), complete DECIMAL(3,2), project_id BIGINT NOT NULL, PRIMARY KEY (id), CONSTRAINT FK_PROJECT FOREIGN KEY (project_id) REFERENCES PROJECT (id) );

insert into project(id, name) values(1, 'aconex');

insert into contract(id,code,description,vendor,budget,committed_cost,forecast,paid,complete,project_id) values(1,'code1','contract1','xyz',1000.00,900.00,800.20,500.30,0.90,1);

insert into contract(id,code,description,vendor,budget,committed_cost,forecast,paid,complete,project_id) values(2,'code2','contract2','abc',2000.00,1900.00,1800.20,1500.30,0.80,1);

insert into contract(id,code,description,vendor,budget,committed_cost,forecast,paid,complete,project_id) values(3,'code3','contract3','abc3',3000.00,2900.00,2800.20,2500.30,0.80,1);

commit;
