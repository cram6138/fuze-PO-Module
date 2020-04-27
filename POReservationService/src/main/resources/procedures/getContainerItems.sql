DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getContainerItems`(In containerId int)
BEGIN
select * from container_items ci inner join item i on i.id = ci.item_id where ci.container_id = containerId;
END$$
DELIMITER ;
