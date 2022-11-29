use projektni_ps;

delimiter $$
create procedure create_napomena (
	in id_djeteta INT,
       opis_napomene varchar(255),
    out je_kreirana bool
)
begin
	set je_kreirana = false;
    insert into napomena (OpisNapomene, DIJETE_OSOBA_IdOsobe) values (opis_napomene, id_djeteta);
    set je_kreirana = true;
end$$
delimiter ;