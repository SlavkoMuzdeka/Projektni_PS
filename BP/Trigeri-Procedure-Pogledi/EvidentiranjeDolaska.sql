use projektni_ps;

delimiter $$
create procedure log_dolazak(
	in id_djeteta INT,
    out neplacenih_clanarina INT,
    out evidentirano bool
)
begin
	set neplacenih_clanarina = 0, evidentirano = false;
    
    insert into vrijeme_dolaska_i_odlaska(DIJETE_OSOBA_IdOsobe, EvidentiranoVrijeme,Tip) values (id_djeteta, NOW(), 0);
    set evidentirano = true;
    
    select count(*) into neplacenih_clanarina
    from clanarina c
    where c.DIJETE_OSOBA_IdOsobe = id_djeteta and c.Placeno = 0;


end$$
delimiter ;

