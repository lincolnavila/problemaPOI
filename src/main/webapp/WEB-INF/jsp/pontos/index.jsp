<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pontos de Interesse</title>
</head>
<body>
        <form id="formPoiCadastro" action="/problemaPOI/poi/save" method="post">
        	<div id="cadastro" style="float:left">
	            Cadastrar POI:<br><br>
	            <input type="text" size="15" id="nome" name="poi.nome" placeholder="Nome" /> <br>
	            <input type="text" size="15" id="coordX" name="poi.coordenadaX" placeholder="Coordenada X" /> <br>
	            <input type="text" size="15" id="coordY" name="poi.coordenadaY" placeholder="Coordenada Y" /><br><br>
	            
	            <input type="submit" value="Cadastrar"  />
            </div>
        </form>
        <form id="formPoiListaTodos" action="/problemaPOI/poi/list" method="post">
            <div id="listarTodos" style="float:left;margin-left:20px">
            	Para a listagem completa:<br><br>
            	<input type="submit" value="Listar Todos" />
            </div>
        </form>
        
        <form id="formPoiListaProximos" action="/problemaPOI/poi/listProximity" method="post">
            <div id="listarProximos" style="float:left;margin-left:20px">
            	Para a listagem por proximidade:<br><br>
            	<input type="text" size="15" id="coordX" name="coordenadaX" placeholder="Coordenada X" /> <br>
	            <input type="text" size="15" id="coordY" name="coordenadaY" placeholder="Coordenada Y" /><br>
	            <input type="text" size="15" id="dMax" name="dMax" placeholder="Distancia maxima" /> <br><br>
	            
	            
            	<input type="submit" value="Listar Próximos" />
            </div>
        </form>
        
    </body>
</html>