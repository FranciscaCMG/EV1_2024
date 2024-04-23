import { Alert, AlertTitle, Box, Button, Collapse, Snackbar } from "@mui/material";
import { useState } from "react";
import AddReactionIcon from '@mui/icons-material/AddReaction';
import { useSnackbar } from "notistack";

export default function Home() {

    const [open, setOpen] = useState(false);
    const { enqueueSnackbar } = useSnackbar();
    const handleClick = () => {
        enqueueSnackbar("Susususcribete",
            {
                variant: "success",
                anchorOrigin: {
                    vertical: "top",
                    horizontal: "right",
                },
            }
        );
    }

    return (
        <>
            <h1>Home</h1>
            <Box sx={{ display: "grid", gap: "1rem" }} >
                <>
                    <h1>Registro</h1>

                    <Button
                        variant="contained"
                        onClick={handleClick}
                    >Open</Button>
                </>

                <Alert
                    severity="warning"
                    action={
                        <>
                            <Button color="inherit">Update</Button>
                            <Button color="inherit">Delete</Button>
                        </>
                    }>
                    This is a warning alert — check it out!
                </Alert>
                <Alert
                    severity="info"
                    icon={<AddReactionIcon />}
                >This is an info alert — check it out!
                </Alert>


                <Button
                    variant="contained"
                    onClick={() => setOpen(true)}>
                    Open Snackbar
                </Button>

                <Snackbar
                    open={open}
                    autoHideDuration={7000}
                    onClose={() => setOpen(false)}>
                    <Alert severity="error">
                        <AlertTitle>Error</AlertTitle>
                        This is an error alert — check it out!
                    </Alert>
                </Snackbar>

            </Box>
        </>
    );

}