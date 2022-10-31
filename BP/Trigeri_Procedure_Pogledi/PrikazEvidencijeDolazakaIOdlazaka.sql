use projektni_ps;

delimiter $$
create procedure get_all_logs(
	in id_djeteta INT
)
begin
	select EvidentiranoVrijeme, Tip
    from vrijeme_dolaska_i_odlaska v
    where v.DIJETE_OSOBA_IdOsobe = id_djeteta;
end$$
delimiter ;