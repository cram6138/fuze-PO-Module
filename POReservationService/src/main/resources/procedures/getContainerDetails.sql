DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getContainerDetails`(in tt varchar(50),in mm varchar(50), in userid int)
BEGIN
select * from container c where 
c.territory like case when tt is null then '%' when tt = '' then '%' else tt end and 
c.reserved_by_user_id like case when userid is null then '%' else userid end and 
c.market like case when mm is null then '%' when mm = '' then '%' else mm end or 
c.cats_status = 'EA';

END$$
DELIMITER ;
