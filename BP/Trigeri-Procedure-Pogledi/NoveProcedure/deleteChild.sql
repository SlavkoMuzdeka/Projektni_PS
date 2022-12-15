DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `deleteChild`(in id int, out rez boolean)
BEGIN
	if exists (select * from osoba o where o.IdOsobe=id) then
		update osoba o set aktivan=0 where o.IdOsobe=id;
        select true into rez;
	else
		select false into rez;
	end if;
END
DELIMITER $$