DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `searchContainer`(in tt varchar(50),in mm varchar(50),in submkt varchar(50),in lcmkt varchar(50),in concode varchar(50),in buyer varchar(50),in prjid varchar(10),in userter varchar(50),in usermarket varchar(50), out message varchar(100))
BEGIN
	DECLARE EXIT HANDLER FOR NOT FOUND SELECT 'container code is not present' as message into message;
	DECLARE EXIT HANDLER FOR 1146 SELECT 'Please create a table first' as message into message; 
	DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' as message into message;
	set message = '';
		if(tt is not null && userter is not null && tt = userter) then
			if(mm is not null && usermarket is not null && mm = usermarket) then
				if(submkt is not null && lcmkt is not null && concode is not null and buyer is not null and prjid is not null) then
					select c.* from container c inner join user u on u.id = c.user_id where c.territory = tt and c.market = mm 
					and c.sub_market like (case when submkt is not null then submkt else '%' end) 
					and c.local_market like (case when lcmkt is not null then lcmkt else '%' end)
					and c.container_code like (case when concode is not null then concode else '%' end)
					and u.username like (case when buyer is not null then buyer else '%' end)
					and c.project_id like (case when prjid is not null then prjid else '%' end)
					and c.cats_status = 'EA';
				else 
					select c.* from container c inner join user u on u.id = c.user_id where c.territory = tt and c.market = mm 
					and c.sub_market like (case when submkt is not null then submkt else '%' end) 
					and c.local_market like (case when lcmkt is not null then lcmkt else '%' end)
					and c.container_code like (case when concode is not null then concode else '%' end)
					and u.username like (case when buyer is not null then buyer else '%' end)
					and c.project_id like (case when prjid is not null then prjid else '%' end);
				end if;
			else 
				select c.* from container c inner join user u on u.id = c.user_id where c.territory = tt 
				and c.market like (case when mm is not null then mm else '%' end)
				and c.sub_market like (case when submkt is not null then submkt else '%' end) 
				and c.local_market like (case when lcmkt is not null then lcmkt else '%' end)
				and c.container_code like (case when concode is not null then concode else '%' end)
				and u.username like (case when buyer is not null then buyer else '%' end)
				and c.project_id like (case when prjid is not null then prjid else '%' end)
				and c.cats_status = 'EA';
			end if;
		else 
			select c.* from container c inner join user u on u.id = c.user_id where 
			c.territory like (case when tt is not null then tt else '%' end)
			and c.market like (case when mm is not null then mm else '%' end)
			and c.sub_market like (case when submkt is not null then submkt else '%' end) 
			and c.local_market like (case when lcmkt is not null then lcmkt else '%' end)
			and c.container_code like (case when concode is not null then concode else '%' end)
			and u.username like (case when buyer is not null then buyer else '%' end)
			and c.project_id like (case when prjid is not null then prjid else '%' end)
			and c.cats_status = 'EA';
		end if;
	END$$
DELIMITER ;
