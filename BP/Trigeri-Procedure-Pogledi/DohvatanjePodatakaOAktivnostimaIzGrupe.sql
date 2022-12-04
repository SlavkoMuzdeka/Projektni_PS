use projektni_ps;

delimiter $$
create procedure get_activities_from_group(
	in id_grupe INT
)
begin
	select a.IdAktivnosti, NazivAktivnosti, OpisAktivnosti, DatumAktivnosti, PeriodAktivnosti
    from aktivnost a
    inner join aktivnost_has_grupa ag on ag.AKTIVNOST_IdAktivnosti = IdAktivnosti
    WHERE ag.GRUPA_IdGrupe = id_grupe;
    
end$$
delimiter ;
