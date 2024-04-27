import { Container } from "@mui/material";
import Navbar from "./components/navbar/Navbar";
import { Route, Routes } from "react-router-dom";
import Home from "./pages/Home";
import Registro from "./pages/Registro";
import ListadoVehiculo from "./pages/ListadoVehiculo";
import Bonos from "./pages/Bonos";
import HomeIcon from '@mui/icons-material/Home';
import NoCrashIcon from '@mui/icons-material/NoCrash';
import Reparacion from "./pages/Reparacion";
import ConstructionIcon from '@mui/icons-material/Construction';
import FormatListNumberedIcon from '@mui/icons-material/FormatListNumbered';
import PercentIcon from '@mui/icons-material/Percent';

// Links o rutas a las que se redirigirá el usuario
const navArrayLinks = [
  {
    title: "Home",
    path: "/",
    icon: <HomeIcon />
  },
  {
    title: "Registro",
    path: "/registro",
    icon: <NoCrashIcon />
  },
  {
    title: "Reparacion",
    path: "/reparacion",
    icon: <ConstructionIcon />
  },
  {
    title: "Listado",
    path: "/listado",
    icon: <FormatListNumberedIcon />
  },
  {
    title: "Bonos",
    path: "/bonos",
    icon: <PercentIcon />
  },


]

export default function App() {
  return (
    <>
      <Navbar navArrayLinks={navArrayLinks} />
      <Container sx={{ mt: 5 }}>
        <Routes>
          <Route
            path="/"
            element={<Home />}
          />
          <Route
            path="/registro"
            element={<Registro />}
          />
          <Route
            path="/reparacion"
            element={<Reparacion />}
          />
          <Route
            path="/listado"
            element={<ListadoVehiculo />}
          />
          <Route
            path="/bonos"
            element={<Bonos />}
          />

        </Routes>
      </Container>
    </>
  );
}