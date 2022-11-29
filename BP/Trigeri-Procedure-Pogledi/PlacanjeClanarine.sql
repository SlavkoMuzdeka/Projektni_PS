use projektni_ps;

delimiter $$
create procedure pay_clanarina (
	in id_clanarine INT
)
begin
	update clanarina c
    set c.Placeno = 1, c.DatumPlacanja = NOW()
    where c.IdClanarine = id_clanarine;
end$$
delimiter ;

