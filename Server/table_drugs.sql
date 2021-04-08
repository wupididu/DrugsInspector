create table drugs(
    id int primary key default nextval('seq_drugs'),
    title	text,
    descr	text,
    amount	int,
    dose	float
);