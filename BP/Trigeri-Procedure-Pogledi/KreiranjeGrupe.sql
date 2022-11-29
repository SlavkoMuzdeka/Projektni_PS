use projektni_ps;

delimiter $$
create procedure create_group (
	in naziv_grupe varchar(50),
    out jeKreirana bool
)
begin
	set jeKreirana = false;
	insert into grupa(NazivGrupe, BrojClanova, Aktivna) values (naziv_grupe, 0, 1);
    set jeKreirana = true;
end$$
delimiter ;

-- drop procedure create_group;

call create_group('Grupa 1', @vrijednost);
select @vrijednost