import * as React from 'react';
import { useEffect } from "react";

import { useRecoilState } from "recoil";

import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import Typography from "@mui/material/Typography";
import { CardActionArea } from "@mui/material";

import HttpService from "../../libs/HttpService";
import articleEntity from "../../libs/entity/ArticleEntity";

import Layout from "../../components/Layout";

const ArticleList = () => {
    const [articles, setArticles] = useRecoilState(articleEntity);

    useEffect(() => {
        (async () => {
            await HttpService.getAxiosClient()
                .get("http://localhost:8080/api/articles")
                .then(articles => setArticles(articles.data.data));
        })();
    }, []);

    return (
        <Layout>
            <div className="mt-20 flex flex-col justify-center">
                <div className="flex flex-col justify-center items-center px-10">
                    {
                        articles.map(({ attributes }) => {
                            return (
                                <CardActionArea>
                                    <Card
                                        sx={{ maxWidth: 1100, height: 200 }}
                                        className="transition duration-200 ease-in-out transform hover:-translate-y-4"
                                    >
                                        <CardContent className='p-6'>
                                            <Typography gutterBottom variant="h5" component="div">
                                                {attributes.title}
                                            </Typography>
                                            <Typography variant="body2" color="text.secondary">
                                                {attributes.body}
                                            </Typography>
                                            <div className='flex'>
                                                <div className="text-sm mt-4 text-blue-600">[{attributes.id}]</div>
                                                <div className="text-sm mt-4 ml-3">
                                                    {attributes.created}
                                                </div>
                                            </div>
                                        </CardContent>
                                    </Card>
                                </CardActionArea>
                            )
                        })
                    }
                </div>
            </div>
        </Layout>
    );
}

export default ArticleList