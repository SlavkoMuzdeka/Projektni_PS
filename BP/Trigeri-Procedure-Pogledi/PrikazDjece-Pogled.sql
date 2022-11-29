create view prikaz_djece as
	select JMB,Ime,Prezime,DatumRodjenja,Ulica,Grad,Broj,Visina,Tezina,ImeOca,ImeMajke,BrojTelefonaOca,BrojTelefonaMajke
	from dijete d
	inner join osoba o on o.IdOsobe = d.OSOBA_IdOsobe
	inner join adresa a on a.IdAdrese = o.ADRESA_IdAdrese