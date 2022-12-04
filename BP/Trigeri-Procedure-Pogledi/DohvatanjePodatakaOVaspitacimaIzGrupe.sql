use projektni_ps;

delimiter $$
create procedure get_vaspitaci_from_group(
	in id_grupe INT
)
begin
	select OSOBA_IdOsobe, JMB,Ime,Prezime,DatumRodjenja,Ulica,Grad,Broj
    from osoba o,vaspitac v,grupa g,vaspitac_has_grupa vg,adresa adr
    where o.IdOsobe = v.OSOBA_IdOsobe
		and g.IdGrupe = vg.GRUPA_IdGrupe
        and adr.IdAdrese = o.ADRESA_IdAdrese
        and v.OSOBA_IdOsobe = vg.VASPITAC_OSOBA_IdOsobe
        and g.IdGrupe = id_grupe;
end$$
delimiter ;