create view prikaz_vaspitaca as
	select OSOBA_IdOsobe, JMB,Ime,Prezime,DatumRodjenja,Ulica,Grad,Broj
    from vaspitac v
    inner join osoba o on o.IdOsobe = v.OSOBA_IdOsobe
    inner join adresa a on o.ADRESA_IdAdrese = a.IdAdrese;