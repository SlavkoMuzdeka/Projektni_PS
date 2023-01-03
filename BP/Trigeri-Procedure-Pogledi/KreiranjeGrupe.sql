CREATE DEFINER=`root`@`localhost` PROCEDURE `create_group`(
	in naziv_grupe varchar(50),
    out jeKreirana bool
)
begin
	set jeKreirana = false;
	insert into grupa(NazivGrupe, BrojClanova, Aktivna) values (naziv_grupe, 0, 1);
    set jeKreirana = true;
end