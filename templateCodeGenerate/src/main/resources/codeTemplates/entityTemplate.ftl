package ${packageName};

public class ${className} {
<#list fields as field>
    private ${field.classType} ${field.name};
</#list>
<#list fields as field>
    public ${field.classType} get${field.upperName}() {
        return ${field.name};
    }

    public void set${field.upperName}(${field.classType} ${field.name}) {
        this.${field.name} = ${field.name};
    }

</#list>
}
