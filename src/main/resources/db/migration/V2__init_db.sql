INSERT INTO public.copyright (id,clause,due_date) VALUES 
('f3111df3-647a-44fc-8ee7-702bd494b9bd','Some long text about trademark','2024-11-01 01:00:00.000')
,('4f2f59cd-6371-438f-b86c-f873748d373f','Some long text about trademark','2024-11-01 01:00:00.000')
;

INSERT INTO public.product (id,created_at,description,image_url,title,copyright_id) VALUES 
('044a4c78-1ff4-4dae-acd4-040f71b031fe','2021-11-02 01:44:54.485','Original valencian rice','http://mydomain/img_rice.jpg','Valencian rice','f3111df3-647a-44fc-8ee7-702bd494b9bd')
,('b04267a7-71b2-4f4b-bce0-1f6b16525b53','2021-11-02 01:46:17.449','Healthy salad','http://mydomain/img_2.jpg','Caesar salad','4f2f59cd-6371-438f-b86c-f873748d373f')
,('84a33350-88b6-423b-8677-72024800d532','2021-11-02 01:47:34.039','Classic pasta','http://mydomain/img_3.jpg','Spaghetti',NULL)
;
