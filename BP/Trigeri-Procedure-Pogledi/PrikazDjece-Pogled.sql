create view prikaz_djece as
	select OSOBA_IdOsobe, JMB,Ime,Prezime,DatumRodjenja,Ulica,Grad,Broj,Visina,Tezina,ImeOca,ImeMajke,BrojTelefonaOca,BrojTelefonaMajke, Prisutno
	from dijete d
	inner join osoba o on o.IdOsobe = d.OSOBA_IdOsobe
	inner join adresa a on a.IdAdrese = o.ADRESA_IdAdrese;