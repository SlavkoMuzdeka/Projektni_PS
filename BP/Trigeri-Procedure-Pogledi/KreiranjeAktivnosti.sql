use  projektni_ps;

delimiter $$
create procedure create_activity (
	in naziv_aktivnosti varchar(50),
	   opis_aktivnosti varchar(50),
	out jeKreirana bool
)
begin
	set jeKreirana = false;
	insert into aktivnost(NazivAktivnosti, OpisAktivnosti) values (naziv_aktivnosti, opis_aktivnosti);
    set jeKreirana = true;
end$$
delimiter ;

call create_activity('Rekreacija', 'Potrebno je uraditi vjezbe za zagrijavanje',@vrijednost);
select @vrijednost