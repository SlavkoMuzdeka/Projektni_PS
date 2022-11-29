use projektni_ps;

delimiter $$
create procedure log_odlazak(
	in id_djeteta INT,
    out evidentirano bool
)
begin
	set evidentirano = false;
    insert into vrijeme_dolaska_i_odlaska(DIJETE_OSOBA_IdOsobe, EvidentiranoVrijeme,Tip) values (id_djeteta, NOW(), 1);
    set evidentirano = true;
end$$
delimiter ;
