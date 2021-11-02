-- public.copyright definition

-- Drop table

-- DROP TABLE public.copyright;

CREATE TABLE public.copyright (
	id uuid NOT NULL,
	clause varchar(255) NULL,
	due_date timestamp NULL,
	CONSTRAINT copyright_pkey PRIMARY KEY (id)
);


-- public.product definition

-- Drop table

-- DROP TABLE public.product;

CREATE TABLE public.product (
	id uuid NOT NULL,
	created_at timestamp NULL,
	description varchar(255) NULL,
	image_url varchar(255) NULL,
	title varchar(255) NULL,
	copyright_id uuid NULL,
	CONSTRAINT product_pkey PRIMARY KEY (id),
	CONSTRAINT fkptcry7olu8m484u24csbv254o FOREIGN KEY (copyright_id) REFERENCES copyright(id)
);