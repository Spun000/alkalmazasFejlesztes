<h1>Home: http://localhost::8080</h1>

<h1>Futóverseny Kezelő Alkalmazás</h1>
<p>Cél: Fejlessz egy webalkalmazást, amely képes kezelni egy futóverseny résztvevőinek adatait, eredményeit, és megjeleníteni azok statisztikáit.<br></p>
<h2>Funkcionális Követelmények</h2>
<p>Alapvető Entitások<br>
● Futó: név, életkor, nem, és egyéni azonosító.<br>
● Verseny: neve, távolsága (km), azonosító.<br>
● Eredmény: résztvevő, verseny, időeredmény perc.<br>
</p>
<p>Az entitásokhoz vegyünk fel automatikusan tesztadatot a program futtatásakor a H2 adatbázisban (min. 4 futó, 2 verseny, 6 eredmény)</p>
<h2>Alapvető műveletek REST API-n keresztül</h2>
<p>● /getRunners: összes futó alapadatai json struktúrában)<br>
● /addRunner: futó felvétele post payloadban átadott adatok alapján<br>
● /getRaceRunners/{ID}: adott azonosítójú verseny összes futójának neve és időeredménye emelkedő sorrendben)<br>
● /updateRace: POST json payloadban átadott versenyazonsító nevének és távolságának update-je<br>
● /addResult: Új eredmény rögzítése futók és versenyek számára<br>
● /getAverageTime/{VERSENYID} Átlagos futási idő számítása egy adott versenyre</p>
<h2>Thymeleaf frontend</h2>
<p>● Versenyek listázása<br>
● Új verseny létrehozása (név, táv megadásával)<br>
● Versenyek részletek oldala, amelyen a futók eredményei látszódnak (név, időeredmény)</p>

<h2>Technológiai és Implementációs Követelmények</h2>
<p>● A backend Spring Boot keretrendszerrel készüljön, REST API-k formájában szolgáltatva a funkciókat.<br>
● Adattárolásra használjon H2 relációs adatbázist.<br>
● Az adatok közötti kapcsolatok kezelésére használjon JPA-t (Java Persistence API).<br>
● Az alkalmazás biztosítson alapvető hibakezelést és validációt az adatbevitel során.<br>
● Az API-k teszteléséhez készíts Postman hívásokat, és ezek legyen berakva a projektstrukturába a test-ek közé.</p>
<h2>Értékelési Szempontok</h2>
<p>● A kód tisztasága, olvashatósága, és karbantarthatósága.<br>
● A REST API-k megfelelő tervezése és implementálása.<br>
● A funkcionális követelmények teljes körű megvalósítása.<br>
● Az alkalmazás robusztussága és hibakezelése.<br>
● Megfelelő commit-ok és commit message-ek<br></p>
