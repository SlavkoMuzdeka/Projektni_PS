use projektni_ps;

delimiter $$
create procedure get_all_evidencije(
	in id_djeteta INT
)
begin
	select IdClanarine,TipUsluge,Iznos,Placeno,Datum, DatumPlacanja
    from clanarina c
    where DIJETE_OSOBA_IdOsobe = id_djeteta;
end$$
delimiter ;
