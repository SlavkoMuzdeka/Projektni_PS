CREATE DEFINER=`root`@`localhost` PROCEDURE `get_children_from_group`(
	in id_grupe INT
)
begin

	select o.IdOsobe, o.JMB, o.Ime, o.Prezime, o.DatumRodjenja, Ulica, Grad, Broj, Visina, Tezina, ImeOca, ImeMajke, BrojTelefonaOca, BrojTelefonaMajke, OpisNapomene
    from osoba o
    inner join dijete d on o.IdOsobe=d.OSOBA_IdOsobe
    inner join ADRESA a on o.ADRESA_IdAdrese=a.IdAdrese
    inner join dijete_has_grupa dg on dg.DIJETE_OSOBA_IdOsobe = o.IdOsobe
    inner join grupa g on g.IdGrupe = dg.GRUPA_IdGrupe
    left outer join NAPOMENA on dg.DIJETE_OSOBA_IdOsobe=d.OSOBA_IdOsobe
    where aktivan is true AND g.IdGrupe = id_grupe;

end