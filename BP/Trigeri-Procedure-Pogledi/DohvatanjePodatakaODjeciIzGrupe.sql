use projektni_ps;

delimiter $$
create procedure get_childrens_from_group(
	in id_grupe INT
)
begin
	select JMB,Ime,Prezime,DatumRodjenja,Ulica,Grad,Broj,Visina,Tezina,ImeOca,ImeMajke,BrojTelefonaOca,BrojTelefonaMajke
    from osoba o,dijete d,grupa g,dijete_has_grupa dg,adresa adr
    where o.IdOsobe = d.OSOBA_IdOsobe
		and g.IdGrupe = dg.GRUPA_IdGrupe
        and adr.IdAdrese = o.ADRESA_IdAdrese
        and d.OSOBA_IdOsobe = dg.DIJETE_OSOBA_IdOsobe
        and g.IdGrupe = id_grupe;
end$$
delimiter ;
