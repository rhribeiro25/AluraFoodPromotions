CREATE TABLE IF NOT EXISTS promotions (
  id bigint GENERATED ALWAYS AS identity
  	CONSTRAINT pk_order
  		primary key,
  		name varchar(124) NOT NULL
  discount_percentage bigint NOT NULL,
  product_id bigint NOT NULL,
  start_date date NOT NULL,
  finish_date date NOT NULL,
  status varchar(255) NOT NULL
);