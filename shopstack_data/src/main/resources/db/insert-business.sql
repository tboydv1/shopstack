INSERT INTO `shopstack`.`ss_business`(`biz_id`,`biz_name`,`biz_email`, `biz_category_id`, `biz_service_id`, `biz_creator`)

VALUES
(1,'shopify','shopify@mail.com', 2, 2, 6),
(2,'Warfle', 'warfle@mail.com',2, 2, 7);

INSERT INTO `shopstack`.`ss_business_outlet`(`ss_business_outlet_id`, `ss_outlet_display_name`, 
`location`, `ss_business_biz_id`)
VALUES
(7, 'shopify_yaba', '312 semicolon yaba', 1);