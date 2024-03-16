const path = require('path')
const CopyPlugin = require('copy-webpack-plugin')

module.exports = {
    mode: 'development',
    entry: {
        cadastroCandidato:'/src/cadastro/cadastroCandidato.ts',
        cadastroEmpresa:'/src/cadastro/cadastroEmpresa.ts'
    },
    devServer: {
        static: path.join(__dirname, 'dist'),
        port: 9000,
        hot: true,
    },
    output: {
        filename: '[name].min.js',
        path: path.join(__dirname, 'dist')
    },
    plugins: [
        new CopyPlugin({
            patterns: [
                { from: 'public'},
            ],
        }),
    ],
    resolve: {
        extensions: ['.ts', '.js']
    },
    module: {
        rules: [{
            test: /\.ts/,
            use: 'ts-loader',
            exclude: /node_modules/
        }]
    }
}